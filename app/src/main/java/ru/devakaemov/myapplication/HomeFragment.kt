package ru.devakaemov.myapplication

import android.os.Bundle
import android.transition.Scene
import android.transition.Slide
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import ru.devakaemov.myapplication.databinding.FragmentHomeBinding
import ru.devakaemov.myapplication.databinding.MergeHomeScreenContentBinding
import java.util.Locale

class HomeFragment : Fragment() {

    private var bindingFragment: FragmentHomeBinding? = null
    private var _binding: MergeHomeScreenContentBinding? = null
    private val binding get() = _binding!!

    private lateinit var filmsAdapter: FilmListRecyclerAdapter

    private val filmsDataBase = listOf(
        Film(
            "Mario",
            R.drawable.mario,
            "Бруклинские сантехники Марио и Луиджи попадают в волшебное Грибное королевство, и Марио должен объединиться с принцессой Пич, Тоадом и Донки Конгом, чтобы спасти Луиджи от злого Боузера."
        ),
        Film(
            "Minecraft",
            R.drawable.minecraft,
            "Четыре неудачника внезапно оказываются втянутыми через таинственный портал в странную кубическую страну чудес, которая процветает благодаря воображению. Чтобы вернуться домой, им придется освоить этот мир, отправившись на поиски с неожиданным экспертом-ремесленником."
        ),
        Film(
            "SpongeBobMovie",
            R.drawable.spongebobmovie,
            "После того, как любимого питомца Спанч Боба, улитку Гэри, похищает улитка, он и Патрик отправляются в эпическое приключение в затерянный город Атлантик-Сити, чтобы вернуть Гэри домой."
        ),
        Film(
            "WonderWoman",
            R.drawable.wonder_woman,
            "Когда пилот терпит крушение и рассказывает о конфликте во внешнем мире, Диана, амазонская воительница, проходящая обучение, покидает дом, чтобы сражаться на войне, открывая для себя всю свою силу и истинное предназначение."
        ),
        Film(
            "Army of Darkness",
            R.drawable.poster,
            "Когда Эш Уильямс случайно переносится в 1300 год н. э., ему приходится вернуть Некрономикон и сразиться с армией мертвецов, чтобы вернуться домой."
        ),
        Film(
            "Back to the Future",
            R.drawable.poster2,
            "Марти Макфлай, 17-летний ученик старшей школы, случайно попадает на 30 лет в прошлое в путешествующем во времени автомобиле DeLorean, изобретенном его близким другом, ученым-независимым Доком Брауном."
        ),
        Film(
            "Indiana Jones",
            R.drawable.poster3,
            "В 1938 году, после того как его отец пропал без вести во время поисков Святого Грааля, Индиана Джонс снова сталкивается с нацистами, чтобы помешать им завладеть его силами."
        ),
        Film(
            "Jurassic World Rebirth",
            R.drawable.poster4,
            "Спустя пять лет после событий «Доминиона Юрского периода» экспедиция отправляется в изолированные экваториальные регионы, чтобы извлечь ДНК из трех огромных доисторических существ и совершить революционный прорыв в медицине."
        ),
        Film(
            "Thunderbolts",
            R.drawable.thunderbolts,
            "Оказавшись в смертельной ловушке, необычная команда антигероев должна отправиться на опасное задание, которое заставит их столкнуться с самыми темными уголками своего прошлого."
        ),
        Film(
            "Superman",
            R.drawable.superman,
            "Следите за титульным супергероем, который примиряет свое наследие с человеческим воспитанием. Он является воплощением истины, справедливости и человеческого пути в мире, который считает это старомодным."
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragment = FragmentHomeBinding.inflate(inflater,container,false)
        _binding = MergeHomeScreenContentBinding.inflate(inflater, container,false)
        return bindingFragment!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val scene = Scene(bindingFragment!!.homeFragmentRoot, binding.root)
        val searchSlide = Slide(Gravity.TOP).addTarget(R.id.search_view)
        val recyclerSlide = Slide(Gravity.BOTTOM).addTarget(R.id.main_recycler)
        val customTransition = TransitionSet().apply {
            duration = 600
            addTransition(recyclerSlide)
            addTransition(searchSlide)
        }
        TransitionManager.go(scene, customTransition)

        _binding!!.searchView.setOnClickListener {
            _binding!!.searchView.isIconified = false
        }

        _binding!!.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isEmpty()) {
                    filmsAdapter.addItems(filmsDataBase)
                    return true
                }

                val result = filmsDataBase.filter {
                    it.title.toLowerCase(Locale.getDefault())
                        .contains(newText.toLowerCase(Locale.getDefault()))
                }
                filmsAdapter.addItems(result)
                return true
            }
        })

        binding.mainRecycler.apply {
            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                    override fun click(film: Film) {
                        (requireActivity() as MainActivity).launchDetailsFragment(film)
                    }
                })
            adapter = filmsAdapter
            layoutManager = LinearLayoutManager(requireContext())
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
        filmsAdapter.addItems(filmsDataBase)
    }
}
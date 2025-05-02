package ru.devakaemov.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ru.devakaemov.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
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
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
package com.sadewawicak.movietvapps.utils

import com.sadewawicak.movietvapps.data.source.local.entity.MovieEntity
import com.sadewawicak.movietvapps.data.source.local.entity.TvEntity

class FakeDataDummys {

    fun generateDummyMovies(): List<MovieEntity> {
        val movies = ArrayList<MovieEntity>()
        movies.add(
            MovieEntity(
                id = 384018,
                titleMovie = "Fast & Furious Presents: Hobbs & Shaw",
                overview = "A spinoff of The Fate of the Furious, focusing on Johnson's US Diplomatic Security Agent Luke Hobbs forming an unlikely alliance with Statham's Deckard Shaw.",
                date = "2019-08-01",
                rating = "6.6",
                posterPath = "/keym7MPn1icW1wWfzMnW3HeuzWU.jpg"
            )
        )
        movies.add(
            MovieEntity(
                id = 181812,
                titleMovie = "Star Wars: The Rise of Skywalker",
                overview = "The surviving Resistance faces the First Order once again as the journey of Rey, Finn and Poe Dameron continues. With the power and knowledge of generations behind them, the final battle begins.",
                date = "2019-12-18",
                rating = "6.7",
                posterPath = "/keym7MPn1icW1wWfzMnW3HeuzWU.jpg"
            )
        )
        movies.add(
            MovieEntity(
                id = 475557,
                titleMovie = "Joker",
                overview = "The surviving Resistance faces the First Order once again as the journey of Rey, Finn and Poe Dameron continues. With the power and knowledge of generations behind them, the final battle begins.",
                date = "2019-12-18",
                rating = "8.3",
                posterPath = "/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg"
            )
        )
        movies.add(
            MovieEntity(
                id = 475557,
                titleMovie = "Joker",
                overview = "The surviving Resistance faces the First Order once again as the journey of Rey, Finn and Poe Dameron continues. With the power and knowledge of generations behind them, the final battle begins.",
                date = "2019-12-18",
                rating = "8.3",
                posterPath = "/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg"
            )
        )
        return movies
    }

    fun generateDummyTvs(): List<TvEntity> {
        val tvs = ArrayList<TvEntity>()
        tvs.add(
            TvEntity(
                id = 82856,
                titleTvs = "The Mandalorian",
                overview = "Set after the fall of the Empire and before the emergence of the First Order, we follow the travails of a lone gunfighter in the outer reaches of the galaxy far from the authority of the New Republic.",
                date = "2019-11-12",
                rating = "7.9",
                posterPath = "/BbNvKCuEF4SRzFXR16aK6ISFtR.jpg"
            )
        )
        tvs.add(
            TvEntity(
                id = 60625,
                titleTvs = "Rick and Morty",
                overview = "Rick is a mentally-unbalanced but scientifically-gifted old man who has recently reconnected with his family. He spends most of his time involving his young grandson Morty in dangerous, outlandish adventures throughout space and alternate universes. Compounded with Morty's already unstable family life, these events cause Morty much distress at home and school.",
                date = "2019-11-12",
                rating = "8.6",
                posterPath = "/qJdfO3ahgAMf2rcmhoqngjBBZW1.jpg"
            )
        )
        tvs.add(
            TvEntity(
                id = 68507,
                titleTvs = "His Dark Materials",
                overview = "Lyra is an orphan who lives in a parallel universe in which science, theology and magic are entwined. Lyra's search for a kidnapped friend uncovers a sinister plot involving stolen children, and turns into a quest to understand a mysterious phenomenon called Dust. She is later joined on her journey by Will, a boy who possesses a knife that can cut windows between worlds. As Lyra learns the truth about her parents and her prophesied destiny, the two young people are caught up in a war against celestial powers that ranges across many worlds.",
                date = "2019-11-12",
                rating = "7.6",
                posterPath = "/qJdfO3ahgAMf2rcmhoqngjBBZW1.jpg"
            )
        )
        return tvs
    }

}
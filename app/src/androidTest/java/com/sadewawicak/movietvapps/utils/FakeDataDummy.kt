package com.sadewawicak.movietvapps.utils

import com.sadewawicak.movietvapps.data.source.local.entity.MovieEntity

class FakeDataDummy {

    /*fun generateMovies(): ArrayList<MovieEntity> {
        val movies = arrayListOf<MovieEntity>()

        movies.add(
            MovieEntity(
                "a1",
                "Star Wars: Episode IX - The Rise of Skywalker",
                "The surviving Resistance faces the First Order once more in the final chapter of the Skywalker saga",
                "Action, Adventure, Fantasy",
                "18 December 2019 (Indonesia)",
                "https://m.media-amazon.com/images/M/MV5BMDljNTQ5ODItZmQwMy00M2ExLTljOTQtZTVjNGE2NTg0NGIxXkEyXkFqcGdeQXVyODkzNTgxMDg@._V1_SY1000_CR0,0,675,1000_AL_.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "a2",
                "The Shawshank Redemption",
                "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                "Drama",
                "14 October 1994 (USA)",
                "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "b1",
                "The Dark Knight",
                "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice",
                "Action, Crime, Drama",
                "18 July 2008 (Indonesia)",
                "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_SY1000_CR0,0,675,1000_AL_.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "b2",
                "Inception",
                "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
                "Action, Adventure, Sci-Fi",
                "16 July 2010 (Indonesia)",
                "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_UX182_CR0,0,182,268_AL_.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "b3",
                "Joker",
                "In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker.",
                "Crime, Drama, Thriller",
                "2 October 2019 (Indonesia)",
                "https://m.media-amazon.com/images/M/MV5BNGVjNWI4ZGUtNzE0MS00YTJmLWE0ZDctN2ZiYTk2YmI3NTYyXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX182_CR0,0,182,268_AL_.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "b4",
                "Ford v Ferrari",
                "American car designer Carroll Shelby and driver Ken Miles battle corporate interference, the laws of physics and their own personal demons to build a revolutionary race car for Ford and challenge Ferrari at the 24 Hours of Le Mans in 1966.",
                "Action, Biography, Drama",
                "2 October 2019 (Indonesia)",
                "https://m.media-amazon.com/images/M/MV5BYzcyZDNlNDktOWRhYy00ODQ5LTg1ODQtZmFmZTIyMjg2Yjk5XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX182_CR0,0,182,268_AL_.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "b5",
                "Midway",
                "The story of the Battle of Midway, told by the leaders and the sailors who fought it.",
                "Action, Drama, History",
                "2 October 2019 (Indonesia)",
                "https://m.media-amazon.com/images/M/MV5BMGVkNGMyMGEtMDNmOC00ZGYyLWEzOTItODdjMzRlZTk4MzUwXkEyXkFqcGdeQXVyODM2Njg2OTg@._V1_UY268_CR16,0,182,268_AL_.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "b6",
                "Frozen II",
                "Anna, Elsa, Kristoff, Olaf and Sven leave Arendelle to travel to an ancient, autumn-bound forest of an enchanted land. They set out to find the origin of Elsa's powers in order to save their kingdom.",
                "Action, Drama, History",
                "2 October 2019 (Indonesia)",
                "https://m.media-amazon.com/images/M/MV5BMjA0YjYyZGMtN2U0Ni00YmY4LWJkZTItYTMyMjY3NGYyMTJkXkEyXkFqcGdeQXVyNDg4NjY5OTQ@._V1_UX182_CR0,0,182,268_AL_.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "b7",
                "Last Christmas",
                "Kate is a young woman subscribed to bad decisions. Working as an elf in a year round Christmas store is not good for the wannabe singer. However, she meets Tom there. Her life takes a new turn. For Kate, it seems too good to be true.",
                "Action, Drama, History",
                "2 October 2019 (Indonesia)",
                "https://m.media-amazon.com/images/M/MV5BNTQ4ZmY0NjgtYzVhNy00NzhiLTk3YTYtNzM1MTdjM2VhZDA3XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX182_CR0,0,182,268_AL_.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "b8",
                "Knives Out",
                "A detective investigates the death of a patriarch of an eccentric, combative family.",
                "Action, Drama",
                "3 October 2019 (Indonesia)",
                "https://m.media-amazon.com/images/M/MV5BMGUwZjliMTAtNzAxZi00MWNiLWE2NzgtZGUxMGQxZjhhNDRiXkEyXkFqcGdeQXVyNjU1NzU3MzE@._V1_UX182_CR0,0,182,268_AL_.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "b9",
                "Charlie's Angels",
                "When a young systems engineer blows the whistle on a dangerous technology, Charlie's Angels are called into action, putting their lives on the line to protect us all.",
                "Action, History",
                "10 October 2019 (Indonesia)",
                "https://m.media-amazon.com/images/M/MV5BN2VkMjQwZWMtMzc1NC00ZjJiLWJlNTMtNmRjOTE2ZTJmYzUwXkEyXkFqcGdeQXVyMjUxMTY3ODM@._V1_UY268_CR7,0,182,268_AL_.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "b10",
                "Playmobil: The Movie",
                "Animated feature film inspired by the Playmobil brand toys.",
                "Animation, Adventure, Comedy",
                "30 August 2019 (Indonesia)",
                "https://m.media-amazon.com/images/M/MV5BMGNlMjY2Y2MtNWVjZS00NDY5LTkwNzYtOTAxODg3Y2ZiY2Q3XkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX182_CR0,0,182,268_AL_.jpg"
            )
        )

        movies.add(
            MovieEntity(
                "b11",
                "Portrait de la jeune fille en feu",
                "On an isolated island in Brittany at the end of the eighteenth century, a female painter is obliged to paint a wedding portrait of a young woman.",
                "Drama, Romance",
                "18 September 2019 (France)",
                "https://m.media-amazon.com/images/M/MV5BNjgwNjkwOWYtYmM3My00NzI1LTk5OGItYWY0OTMyZTY4OTg2XkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_UY268_CR0,0,182,268_AL_.jpg"
            )
        )

        return movies
    }

    fun generateTVs(): ArrayList<TVShowEntity> {
        val tvs = arrayListOf<TVShowEntity>()

        tvs.add(
            TVShowEntity(
                "v1",
                "Planet Earth II",
                "Documentary",
                "TV Mini-Series (2016)",
                "David Attenborough returns in this breathtaking documentary showcasing life on Planet Earth.",
                "https://m.media-amazon.com/images/M/MV5BZWYxODViMGYtMGE2ZC00ZGQ3LThhMWUtYTVkNGE3OWU4NWRkL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyMjYwNDA2MDE@._V1_UX182_CR0,0,182,268_AL_.jpg"
            )
        )

        tvs.add(
            TVShowEntity(
                "v2",
                "Band of Brothers",
                "Action, Drama, History",
                "TV Mini-Series (2001)",
                "The story of Easy Company of the U.S. Army 101st Airborne Division, and their mission in World War II Europe, from Operation Overlord, through V-J Day.",
                "https://m.media-amazon.com/images/M/MV5BMTI3ODc2ODc0M15BMl5BanBnXkFtZTYwMjgzNjc3._V1_UX182_CR0,0,182,268_AL_.jpg"
            )
        )

        tvs.add(
            TVShowEntity(
                "v3",
                "Blue Planet II",
                "Documentary",
                "TV Mini-Series (2017–2018)",
                "David Attenborough returns to the world's oceans in this sequel to the acclaimed documentary filming rare and unusual creatures of the deep, as well as documenting the problems our oceans face.",
                "https://m.media-amazon.com/images/M/MV5BYjg2ODk0MjUtNmMzZS00MjY0LWI1YWMtN2JhMjRmZGUwY2I3XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UY268_CR4,0,182,268_AL_.jpg"
            )
        )

        tvs.add(
            TVShowEntity(
                "v4",
                "Chernobyl",
                "Drama, History, Thriller",
                "TV Mini-Series (2019)",
                "In April 1986, an explosion at the Chernobyl nuclear power plant in the Union of Soviet Socialist Republics becomes one of the world's worst man-made catastrophes.",
                "https://m.media-amazon.com/images/M/MV5BNTEyYmIzMDUtNWMwNC00Y2Q1LWIyZTgtMGY1YzUxOTAwYTAwXkEyXkFqcGdeQXVyMjIyMTc0ODQ@._V1_UX182_CR0,0,182,268_AL_.jpg"
            )
        )

        tvs.add(
            TVShowEntity(
                "v5",
                "Game of Thrones",
                "Action, Adventure, Drama",
                "TV Series (2011–2019)",
                "Nine noble families fight for control over the mythical lands of Westeros, while an ancient enemy returns after being dormant for thousands of years.",
                "https://m.media-amazon.com/images/M/MV5BMjA5NzA5NjMwNl5BMl5BanBnXkFtZTgwNjg2OTk2NzM@._V1_UX182_CR0,0,182,268_AL_.jpg"
            )
        )

        tvs.add(
            TVShowEntity(
                "v6",
                "Rick and Morty",
                "Animation, Adventure, Comedy",
                "TV Series (2013– )",
                "An animated series that follows the exploits of a super scientist and his not-so-bright grandson.",
                "https://m.media-amazon.com/images/M/MV5BMjRiNDRhNGUtMzRkZi00MThlLTg0ZDMtNjc5YzFjYmFjMmM4XkEyXkFqcGdeQXVyNzQ1ODk3MTQ@._V1_UY268_CR2,0,182,268_AL_.jpg"
            )
        )

        tvs.add(
            TVShowEntity(
                "v7",
                "Avatar: The Last Airbender",
                "Animation, Action, Adventure",
                "TV Series (2005–2008)",
                "In a war-torn world of elemental magic, a young boy reawakens to undertake a dangerous mystic quest to fulfill his destiny as the Avatar, and bring peace to the world.",
                "https://m.media-amazon.com/images/M/MV5BNzZlZmQyYTgtOWNmMy00NTNhLTgyOTYtNjhiOTllOGU2MDg5XkEyXkFqcGdeQXVyMjYxMzY2NDk@._V1_UY268_CR0,0,182,268_AL_.jpg"
            )
        )

        tvs.add(
            TVShowEntity(
                "v8",
                "Cosmos",
                "Documentary",
                "TV Series (2014–2020)",
                "An exploration of our discovery of the laws of nature and coordinates in space and time.",
                "https://m.media-amazon.com/images/M/MV5BZTk5OTQyZjYtMDk3Yy00YjhmLWE2MTYtZmY4NTg1YWUzZTQ0XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_UX182_CR0,0,182,268_AL_.jpg"
            )
        )

        tvs.add(
            TVShowEntity(
                "v9",
                "Sherlock",
                "Crime, Drama, Mystery",
                "TV Series (2010– )",
                "A modern update finds the famous sleuth and his doctor partner solving crime in 21st century London.",
                "https://m.media-amazon.com/images/M/MV5BMWY3NTljMjEtYzRiMi00NWM2LTkzNjItZTVmZjE0MTdjMjJhL2ltYWdlL2ltYWdlXkEyXkFqcGdeQXVyNTQ4NTc5OTU@._V1_UX182_CR0,0,182,268_AL_.jpg"
            )
        )

        tvs.add(
            TVShowEntity(
                "v10",
                "Hagane no renkinjutsushi",
                "Animation, Action, Adventure",
                "TV Series (2009–2012)",
                "Two brothers search for a Philosopher's Stone after an attempt to revive their deceased mother goes awry and leaves them in damaged physical forms.",
                "https://m.media-amazon.com/images/M/MV5BZmEzN2YzOTItMDI5MS00MGU4LWI1NWQtOTg5ZThhNGQwYTEzXkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_UY268_CR4,0,182,268_AL_.jpg"
            )
        )

        tvs.add(
            TVShowEntity(
                "v11",
                "Batman: The Animated Series",
                "Animation, Action, Adventure",
                "TV Series (1992–1995)",
                "The Dark Knight battles crime in Gotham City with occasional help from Robin and Batgirl.",
                "https://m.media-amazon.com/images/M/MV5BOTM3MTRkZjQtYjBkMy00YWE1LTkxOTQtNDQyNGY0YjYzNzAzXkEyXkFqcGdeQXVyOTgwMzk1MTA@._V1_UX182_CR0,0,182,268_AL_.jpg"
            )
        )

        tvs.add(
            TVShowEntity(
                "v12",
                "Africa",
                "Documentary",
                "TV Mini-Series (2013)",
                "Africa, the world's wildest continent. David Attenborough takes us on an awe-inspiring journey through one of the most diverse places in the world. We visit deserts, savannas, and jungles and meet up with some of Africa's amazing wildlife.",
                "https://m.media-amazon.com/images/M/MV5BMjFkYzk3ZDktYThjZC00NDgzLWIzYWEtMjI0N2Y0ZmE5ZDMwXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_UY268_CR5,0,182,268_AL_.jpg"
            )
        )

        return tvs
    }

    fun generateEpisode(tvs: String): ArrayList<EpisodeEntity> {
        val episodes = arrayListOf<EpisodeEntity>()

        episodes.add(
            EpisodeEntity(
                "ep1",
                tvs,
                "Episode 1",
                "David Attenborough returns to the world's oceans in this sequel to the acclaimed documentary filming rare and unusual creatures of the deep, as well as documenting the problems our oceans face."
            )
        )

        episodes.add(
            EpisodeEntity(
                "ep2",
                tvs,
                "Episode 2",
                "David Attenborough returns to the world's oceans in this sequel to the acclaimed documentary filming rare and unusual creatures of the deep, as well as documenting the problems our oceans face."
            )
        )

        episodes.add(
            EpisodeEntity(
                "ep3",
                tvs,
                "Episode 3",
                "David Attenborough returns to the world's oceans in this sequel to the acclaimed documentary filming rare and unusual creatures of the deep, as well as documenting the problems our oceans face."
            )
        )

        episodes.add(
            EpisodeEntity(
                "ep4",
                tvs,
                "Episode 4",
                "David Attenborough returns to the world's oceans in this sequel to the acclaimed documentary filming rare and unusual creatures of the deep, as well as documenting the problems our oceans face."
            )
        )

        episodes.add(
            EpisodeEntity(
                "ep5",
                tvs,
                "Episode 5",
                "David Attenborough returns to the world's oceans in this sequel to the acclaimed documentary filming rare and unusual creatures of the deep, as well as documenting the problems our oceans face."
            )
        )

        return episodes

    }*/

}
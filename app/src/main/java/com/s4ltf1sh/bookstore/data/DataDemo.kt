package com.s4ltf1sh.bookstore.data

import com.s4ltf1sh.bookstore.data.model.Book
import com.s4ltf1sh.bookstore.data.model.CartItem
import com.s4ltf1sh.bookstore.data.model.Category

object DataDemo {
    val listBookDemo = listOf(
        Book(
            id = 1,
            title = "The Picture of Dorian Gray",
            author = "Oscar Wilde",
            rating = 4.5f,
            price = 25.0f,
            cover = "https://images-na.ssl-images-amazon.com/images/I/51QJk0KXZPL._SX331_BO1,204,203,200_.jpg",
            description = "Oscar Wilde’s only novel is the dreamlike story of a young man who sells his soul for eternal youth and beauty. In this celebrated work Wilde forged a devastating portrait of the effects of evil and debauchery on a young aesthete in late-19th-century England. Combining elements of the Gothic horror novel and decadent French fiction, the book centers on a striking premise: As Dorian Gray sinks into a life of crime and gross sensuality, his body retains perfect youth and vigor while his recently painted portrait grows day by day into a hideous record of evil, which he must keep hidden from the world. For over a century, this mesmerizing tale of horror and suspense has enjoyed wide popularity. It ranks as one of Wilde's most important creations and among the classic achievements of its kind.",
            category = "Classic",
            quantity = 10
        ),
        Book(
            id = 2,
            title = "The Catcher in the Rye",
            author = "J.D. Salinger",
            rating = 4.0f,
            price = 30.0f,
            cover = "https://images-na.ssl-images-amazon.com/images/I/51ZJ2q4Z5jL._SX331_BO1,204,203,200_.jpg",
            description = "The hero-narrator of The Catcher in the Rye is an ancient child of sixteen, a native New Yorker named Holden Caulfield. Through circumstances that tend to preclude adult, secondhand description, he leaves his prep school in Pennsylvania and goes underground in New York City for three",
            category = "Classic",
            quantity = 10
        ),
        Book(
            id = 3,
            title = "Nine Liars",
            author = "Maureen Johnson",
            rating = 4.5f,
            price = 16.0f,
            cover = "https://images-na.ssl-images-amazon.com/images/I/51QJk0KXZPL._SX331_BO1,204,203,200_.jpg",
            description = "Nine Liars is a collection of short stories that are all connected in some way",
            category = "Young Adult",
            quantity = 10
        ),
        Book(
            id = 4,
            title = "Sorrow and Starlight",
            author = "Caroline Peckham,\n" +
                    "Susanne Valenti",
            rating = 4.5f,
            price = 30.0f,
            cover = "https://images-na.ssl-images-amazon.com/images/I/51QJk0KXZPL._SX331_BO1,204,203,200_.jpg",
            description = "The thrilling second installment in the bestselling Seraphim Academy series. One click now to continue the epic adventure today!",
            category = "Fantasy",
            quantity = 10
        ),
        Book(
            id = 5,
            title = "Queen of Myth and Monsters",
            author = "Scarlett St. Clair",
            rating = 4.5f,
            price = 24.0f,
            cover = "https://images-na.ssl-images-amazon.com/images/I/51QJk0KXZPL._SX331_BO1,204,203,200_.jpg",
            description = "Persephone and Hades are engaged. In retaliation, Demeter summons a snowstorm that cripples New Greece, and refuses to lift the blizzard unless her daughter calls off her engagement.",
            category = "Fantasy",
            quantity = 10
        ),
        Book(
            id = 6,
            title = "Empire of Ice and Stone",
            author = "Buddy Levy",
            rating = 4.5f,
            price = 30.0f,
            cover = "https://images-na.ssl-images-amazon.com/images/I/51QJk0KXZPL._SX331_BO1,204,203,200_.jpg",
            description = "Empire of Ice and Stone is Buddy Levy's first novel, and it's a good one. The story is set in a world where the Ice Giants and the Stone Giants are at war. The Ice Giants are winning, and the Stone Giants are desperate. They send a small group of warriors to the Ice Giants' stronghold to try to steal a powerful artifact that will help them win the war.",
            category = "History",
            quantity = 10
        )
    )

    val listBookSearchDemo = listOf(
        Book(
            id = 1,
            title = "The Picture of Dorian Gray",
            author = "Oscar Wilde",
            rating = 4.5f,
            price = 25.0f,
            cover = "https://images-na.ssl-images-amazon.com/images/I/51QJk0KXZPL._SX331_BO1,204,203,200_.jpg",
            description = "Oscar Wilde’s only novel is the dreamlike story of a young man who sells his soul for eternal youth and beauty. In this celebrated work Wilde forged a devastating portrait of the effects of evil and debauchery on a young aesthete in late-19th-century England. Combining elements of the Gothic horror novel and decadent French fiction, the book centers on a striking premise: As Dorian Gray sinks into a life of crime and gross sensuality, his body retains perfect youth and vigor while his recently painted portrait grows day by day into a hideous record of evil, which he must keep hidden from the world. For over a century, this mesmerizing tale of horror and suspense has enjoyed wide popularity. It ranks as one of Wilde's most important creations and among the classic achievements of its kind.",
            category = "Classic",
            quantity = 10
        ),
        Book(
            id = 2,
            title = "The Catcher in the Rye",
            author = "J.D. Salinger",
            rating = 4.0f,
            price = 30.0f,
            cover = "https://images-na.ssl-images-amazon.com/images/I/51ZJ2q4Z5jL._SX331_BO1,204,203,200_.jpg",
            description = "The hero-narrator of The Catcher in the Rye is an ancient child of sixteen, a native New Yorker named Holden Caulfield. Through circumstances that tend to preclude adult, secondhand description, he leaves his prep school in Pennsylvania and goes underground in New York City for three",
            category = "Classic",
            quantity = 10
        ),
    )

    val listCategoryDemo = listOf(
        Category(
            id = 1,
            name = "Classic",
            cover = "https://images-na.ssl-images-amazon.com/images/I/51QJk0KXZPL._SX331_BO1,204,203,200_.jpg"
        ),
        Category(
            id = 2,
            name = "Young Adult",
            cover = "https://images-na.ssl-images-amazon.com/images/I/51QJk0KXZPL._SX331_BO1,204,203,200_.jpg"
        ),
        Category(
            id = 3,
            name = "Fantasy",
            cover = "https://images-na.ssl-images-amazon.com/images/I/51QJk0KXZPL._SX331_BO1,204,203,200_.jpg"
        ),
        Category(
            id = 4,
            name = "History",
            cover = "https://images-na.ssl-images-amazon.com/images/I/51QJk0KXZPL._SX331_BO1,204,203,200_.jpg"
        )
    )

    val listItemCartDemo = listOf(
        CartItem(
            id = 1,
            book = listBookDemo[0],
            quantity = 1
        ),
        CartItem(
            id = 2,
            book = listBookDemo[1],
            quantity = 2
        )
    )

    val bookDemo = listBookDemo[0]
}

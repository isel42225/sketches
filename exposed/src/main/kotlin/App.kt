import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args : Array<String>) {
    Database.connect("jdbc:postgresql://localhost:5432/Test", "org.postgresql.Driver", "postgres", "margis1000sexy")

    transaction { SchemaUtils.create(A, B) }
    //transaction { B.select { B.a eq 1 } }
    val id = transaction {
        A.insertAndGetId { it[A.name] = "A" }
    }

    transaction {
        B.insertAndGetId {
            it[B.name] = "B"
            it[B.a] = id
        }

    }
    println(id)

}
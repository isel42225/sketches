import org.jetbrains.exposed.dao.IntIdTable

object A : IntIdTable() {
    val name = text("name")
}

object B : IntIdTable() {
    val name = text("name")
    val a = reference("a", A.id)
}
val incBy1 = (x: Int) => x + 1 //not a closure

var more = 10
val incByMore = (x: Int) => x + more //closure

incBy1(10)

incByMore(12)

val more = 100

incByMore(12)

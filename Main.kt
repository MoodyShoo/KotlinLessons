import kotlin.random.Random

data class Philosopher(val name: String)

data class Fork(val id: Int) {
    enum class State{
        FREE,
        TAKEN
    }
    var state = State.FREE
}

private fun theTableProblem(
    philosophers: ArrayList<Philosopher>,
    philosopherCount: Int,
    forks: ArrayList<Fork>
) {
    var currentPhilosopherIndex = philosophers.indices.random()

    for (i in 0..<philosopherCount) {
        val currentPhilosopher = philosophers[currentPhilosopherIndex]
        val leftFork = forks[currentPhilosopherIndex]
        val rightFork = forks[(currentPhilosopherIndex - 1 + philosopherCount) % philosopherCount]

        if (leftFork.state == Fork.State.FREE && rightFork.state == Fork.State.FREE) {
            val choice = Random.nextInt(0, 2)
            when (choice) {
                0 -> {
                    leftFork.state = Fork.State.TAKEN
                    println("Философ ${currentPhilosopher.name} взял левую вилку и ест")
                }

                1 -> {
                    rightFork.state = Fork.State.TAKEN
                    println("Философ ${currentPhilosopher.name} взял правую вилку и ест")
                }
            }
        } else if (leftFork.state == Fork.State.FREE) {
            leftFork.state = Fork.State.TAKEN
            println("Философ ${currentPhilosopher.name} взял левую вилку и ест")
        } else if (rightFork.state == Fork.State.FREE) {
            rightFork.state = Fork.State.TAKEN
            println("Философ ${currentPhilosopher.name} взял правую вилку и ест")
        } else println("Философ ${currentPhilosopher.name} думает")

        currentPhilosopherIndex = (currentPhilosopherIndex + 1) % philosopherCount
    }
}
fun main() {
    print("Введите количество философов за столом: ")
    val philosopherCount = readln().toInt()

    val philosophers = ArrayList<Philosopher>()
    val forks = ArrayList<Fork>()

    for (i in 0..<philosopherCount) {
        print("Введите имя философа: ")
        val namePhilosopher = readln()
        philosophers.add(Philosopher(namePhilosopher))
        forks.add(Fork(i))
    }
    theTableProblem(philosophers, philosopherCount, forks)
}

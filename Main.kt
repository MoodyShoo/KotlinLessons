import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger

suspend fun main() = runBlocking {

    print("Введите через сколько секунд прозвенит будильник 1: ")
    val time1 = readln().toInt()
    print("Введите через сколько секунд прозвенит будильник 2: ")
    val time2 = readln().toInt()
    print("Введите через сколько секунд прозвенит будильник 3: ")
    val time3 = readln().toInt()

    val boomCounter = AtomicInteger(0)

    val job1 = launch {
        for (i in 1..<time1) {
            print("click\t")
            delay(1000)
        }
        print("BOOM\t")
        boomCounter.incrementAndGet()
    }

    val job2 = launch {
        for (i in 1..< time2) {
            print("chick\t")
            delay(1000)
        }
        print("BOOM\t")
        boomCounter.incrementAndGet()
    }

    val job3 = launch {
        for (i in 1..<time3) {
            print("tick\t")
            delay(1000)
        }
        print("BOOM\t")
        boomCounter.incrementAndGet()
    }

    launch {
        while (boomCounter.get() < 3) {
            println()
            delay(1000)
        }
    }

    job1.join()
    job2.join()
    job3.join()
    println()
}

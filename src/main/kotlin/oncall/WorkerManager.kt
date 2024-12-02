package oncall

import java.util.*

class WorkerManager(
    private val workers: List<String>
) {
    private val workersQueue = LinkedList(workers)

    init {
        require(workers.distinct().size == workers.size) { "[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요." }
        require(workers.size in 5..35) { "[ERROR] 비상 근무자는 최소 5명 최대 35명까지만 입력해 주세요." }
        workers.forEach { worker ->
            require(worker.length in 1..5) { "[ERROR] 비상 근무자 닉네임은 1에서 5자리를 입력해 주세요." }
            worker.length
        }
    }

    fun getWorkerName(
        previousWorkerName: String,
    ): String {
        workerNameRefill(workers, workersQueue)
        return extractWorkName(previousWorkerName, workersQueue)
    }

    private fun workerNameRefill(workers: List<String>, emptyWorkers: LinkedList<String>) {
        if (emptyWorkers.size <= 2) {
            emptyWorkers.addAll(workers)
        }
    }

    private fun extractWorkName(previousWorkerName: String, workers: LinkedList<String>) =
        if (previousWorkerName == workers.peek()) workers.removeAt(1)
        else workers.poll()
}
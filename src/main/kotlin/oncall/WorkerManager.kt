package oncall

import java.util.*

class WorkerManager(
    private val workers: List<String>
) {
    private val workersQueue = LinkedList(workers)

    init {
        require(workers.distinct().size == workers.size) { Error.DUPLICATE_WORKER_NAME.getMessage() }
        require(workers.size in 5..35) { Error.WORKER_RANGE.getMessage() }
        workers.forEach { worker ->
            require(worker.length in 1..5) { Error.WORKER_NAME_LENGTH.getMessage() }
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
package oncall

import java.util.*

class WorkerManager(
    private val workers: List<String>
) {
    private val workersQueue = LinkedList(workers)

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
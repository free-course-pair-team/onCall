package oncall.model

class OnCallWorkforce(private val workForces: List<String>) {

    private var waitingWorkforce: String? = null
    private var current = 0
    var length = workForces.size

    fun getNext(): String {
        if (waitingWorkforce != null) {
            val temp = waitingWorkforce!!
            waitingWorkforce = null
            return temp
        }
        return workForces[(current++) % length]
    }

    fun setWaitingWorkforce(workForces: String) {
        waitingWorkforce = workForces
    }

    fun getPeekWorkforce() =
        workForces[current]

}
package easy

fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {

    val winnersPoints = mutableMapOf<String, Int>()
    var winnerIndex: Int
    var winnerTeam: String

    for ((index, teams) in competitions.withIndex()) {
        winnerIndex = if (results[index] == 0) 1 else 0;
        winnerTeam = teams[winnerIndex]
        if (winnersPoints.contains(winnerTeam)) {
            winnersPoints[winnerTeam] = winnersPoints[winnerTeam]!!.plus(3)
        } else {
            winnersPoints[winnerTeam] = 3
        }
    }

    return winnersPoints.filterValues { it == winnersPoints.values.maxOrNull() }.keys.first()
}

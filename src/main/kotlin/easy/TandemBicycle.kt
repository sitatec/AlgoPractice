package easy

import kotlin.math.max

fun tandemBicycle(redShirtSpeeds: MutableList<Int>, blueShirtSpeeds: MutableList<Int>, fastest: Boolean): Int {
    redShirtSpeeds.sort()
    if(fastest){
        blueShirtSpeeds.sortDescending()
    }else {
        blueShirtSpeeds.sort()
    }

    var totalSpeed = 0

    for(i in 0 until redShirtSpeeds.size){
        totalSpeed += max(redShirtSpeeds[i], blueShirtSpeeds[i])
    }

    return totalSpeed
}
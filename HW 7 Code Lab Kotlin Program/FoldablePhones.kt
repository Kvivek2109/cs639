open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }
    
    fun switchOff() {
        isScreenLightOn = false
    }
    
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone : Phone() {
    var isFolded: Boolean = false

    override fun switchOn() {
        if (!isFolded) {
            super.switchOn()
        } else {
            super.switchOff()
        }
    }
    
    fun changeFoldingState() {
        isFolded = !isFolded
        if (isFolded) {
            println("Phone is folded.")
        } else {
            println("Phone is unfolded")
        }
    }
}

fun main() {    
    val myPhone = FoldablePhone()
    
    myPhone.switchOn()
    myPhone.checkPhoneScreenLight()

    myPhone.changeFoldingState()
    myPhone.switchOn()
    myPhone.checkPhoneScreenLight()

    myPhone.changeFoldingState()
    myPhone.switchOn()
    myPhone.checkPhoneScreenLight()
}
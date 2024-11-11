/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class SmartDevice protected constructor(val name:String,val category:String) {
    var deviceStatus:String ="online"
    	protected set
    
    open var deviceType = "unknown"
    open fun turnOn(){
        deviceStatus = "on"
    }
    open fun turnOff(){
        deviceStatus = "off"
    }
}

class SmartTvDevice(deviceName:String,deviceCategory:String) : 
		SmartDevice(name=deviceName,category=deviceCategory){
    override var deviceType = "Smart TV"
	private var speakerVolume by RangeRegulator(2,0,100)

    private var channelNumber by RangeRegulator(1,0,200)

    fun increaseSpeakerVolume(){
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }
    fun nextChannel(){
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }
    override fun turnOn(){
        super.turnOn()
        println("$name is turned on. Speaker volume is set to $speakerVolume and channel number is " + "set to $channelNumber.")
    }
    override fun turnOff(){
        super.turnOff()
        println("$name turned off")
    }

}
        
class SmartLightDevice(deviceName:String,deviceCategory:String) :
	SmartDevice(name=deviceName,category=deviceCategory){
    override var deviceType = "Smart Light"
        
    private var brightnessLevel by RangeRegulator(0,0,100)
        
    fun increaseBrightness(){
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }
    override fun turnOn(){
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }
    override fun turnOff(){
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice : SmartLightDevice
){
    var deviceTurnOnCount = 0
    	private set
    fun turnOnTv(){
        deviceTurnOnCount++
        smartTvDevice.turnOn()
    }
    fun turnOffTv(){
        deviceTurnOnCount--
        smartTvDevice.turnOff()
    }
    fun increaseTvVolume(){
        smartTvDevice.increaseSpeakerVolume()
    }
    fun changeTvChannelToNext(){
        smartTvDevice.nextChannel()
    }
    fun turnOnLight(){
        deviceTurnOnCount++
        smartLightDevice.turnOn()
    }
    fun turnOffLight(){
        deviceTurnOnCount--
        smartLightDevice.turnOff()
    }
    fun increaseLightBrightness(){
        smartLightDevice.increaseBrightness()
    }
    fun turnOffAllDevices(){
        turnOffLight()
        turnOffTv()
    }
    
}

class RangeRegulator(
    val initialValue:Int,
    private val minValue:Int,
    private val maxValue:Int
) : ReadWriteProperty<Any?,Int> {
    
    var fieldData = initialValue
    override fun getValue(thisRef: Any?, property: KProperty<*>) :  Int {
        return fieldData
    }
    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int){
        if(value in minValue..maxValue)
        	fieldData = value
    }
}
    
fun main() {
    
    var smartDevice :SmartDevice = SmartTvDevice("Android Tv","Entertainment")
    smartDevice.turnOn()
    smartDevice =  SmartLightDevice("Google Light","Utility")
    smartDevice.turnOn()
}
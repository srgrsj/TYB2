package com.example.tyb2.presentation.components

//fun Modifier.vibrate(duration: Long): Modifier {
//    return this.then(VibrateModifier(duration))
//}
//class VibrateModifier(private val duration: Long) : Modifier.Element {
//    override fun <T> foldIn(initial: T, operation: (T, Modifier.Element) -> T): T {
//        return operation(initial, this)
//    }
//
//    override fun <T> foldOut(initial: T, operation: (Modifier.Element, T) -> T): T {
//        return operation(this, initial)
//    }
//
//    fun triggerVibration() {
//        val context = LocalContext.current
//        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val effect = VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE)
//            vibrator.vibrate(effect)
//        } else {
//            vibrator.vibrate(duration)
//        }
//    }
//}
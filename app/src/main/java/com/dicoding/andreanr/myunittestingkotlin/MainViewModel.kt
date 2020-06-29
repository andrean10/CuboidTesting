package com.dicoding.andreanr.myunittestingkotlin

class MainViewModel(private  val cuboidModel: CuboidModel) {
    fun getVolume(): Double = cuboidModel.getVolume()
    fun getSurfaceArea(): Double = cuboidModel.getSurfaceArea()
    fun getCircumference(): Double = cuboidModel.getCircumference()
    fun save(l: Double, w: Double, h: Double) = cuboidModel.save(l, w, h)
}
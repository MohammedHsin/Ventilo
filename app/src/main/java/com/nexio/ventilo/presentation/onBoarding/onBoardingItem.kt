package com.nexio.ventilo.presentation.onBoarding

import com.nexio.ventilo.R

class OnBoardingItem(
    val title:Int,
    val text:Int,
    val image:Int,
) {

    companion object{

        fun get():List<OnBoardingItem>{
            return listOf(
                OnBoardingItem(R.string.onText,R.string.onText, R.drawable.onboarding1),
                OnBoardingItem(R.string.onText,R.string.onText,R.drawable.onboarding2),
                OnBoardingItem(R.string.onText,R.string.onText,R.drawable.onboarding3),
            )
        }

    }

}
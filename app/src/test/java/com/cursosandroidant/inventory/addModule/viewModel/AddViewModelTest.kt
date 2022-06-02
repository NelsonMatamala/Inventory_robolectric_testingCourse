package com.cursosandroidant.inventory.addModule.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cursosandroidant.inventory.entities.Product
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AddViewModelTest {
    @get:Rule
    var instantExcecutorRule = InstantTaskExecutorRule()

    @Test
    fun addProductTest() {
        val addViewModel = AddViewModel()
        val product = Product(117,"MacBook m1",15,
            "https://www.trustedreviews.com/wp-content/uploads/sites/54/2020/12/macbookairm1-4-scaled.jpg",
            4.8,56)

        val observer = Observer<Boolean>{}
        try {
            addViewModel.getResult().observeForever(observer)
            addViewModel.addProduct(product)
            val result = addViewModel.getResult().value
            assertThat(result,`is`(true))
           // assertThat(result, not(nullValue())) opcional
        } finally {
            addViewModel.getResult().removeObserver(observer)
        }

    }
}
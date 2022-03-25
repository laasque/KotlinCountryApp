package com.example.kotlincountryapptry.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.example.kotlincountryapptry.R
import com.example.kotlincountryapptry.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment() {
private lateinit var viewModel: DetailViewModel
    var countryUuid=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProviders.of(this).get(DetailViewModel::class.java)
        viewModel.getDataFromRoom()




        arguments?.let {
            countryUuid=DetailFragmentArgs.fromBundle(it).countryUuid
        }
    }
    private fun observeLiveData(){
        viewModel.detailLiveData.observe(viewLifecycleOwner, Observer { country->
            country?.let{
                countryName.text=country.countryName
                countryCapital.text=country.countryCapital
                countryCurrency.text=country.countryCurrency
                countryRegion.text=country.countryRegion
                countryLanguage.text=country.countryLanguage
            }
        })
    }
}
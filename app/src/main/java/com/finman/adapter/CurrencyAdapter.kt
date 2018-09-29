package com.finman.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.finman.R
import com.finman.model.enums.Currency
import kotlinx.android.synthetic.main.currency_spinner_item_dropdown.view.*

class CurrencyAdapter(context: Context) : ArrayAdapter<Currency>(context, LAYOUT, Currency.values()) {

    companion object {
        const val LAYOUT = R.layout.currency_spinner_item
        const val DROPDOWN_LAYOUT = R.layout.currency_spinner_item_dropdown
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(LAYOUT, null)
        val currency = Currency.values()[position]
        view.tvCurrency.text = currency.toString()
        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(DROPDOWN_LAYOUT, null)
        setupDropdownView(view, position)
        return view
    }

    private fun setupDropdownView(view: View, position: Int) {
        val currency = Currency.values()[position]
        view.apply {
            ivImage.setImageResource(currency.getDrawableResId())
            tvCurrency.text = currency.toString()
            divider.visibility =
                    if (position == Currency.values().lastIndex) View.GONE
                    else View.VISIBLE
        }
    }
}
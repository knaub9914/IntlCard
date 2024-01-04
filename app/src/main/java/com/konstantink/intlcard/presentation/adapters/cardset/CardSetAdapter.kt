package com.konstantink.intlcard.presentation.adapters.cardset

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.konstantink.intlcard.databinding.CardSetBinding
import com.konstantink.intlcard.domain.entities.CardSet
import com.konstantink.intlcard.presentation.viewholders.CardSetViewHolder

class CardSetAdapter(private val context: Context,
                     private val longListener: (CardSet) -> Boolean,
                     private val listener: (CardSet) -> Unit) :
    ListAdapter<CardSet, CardSetViewHolder>(CardSetCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardSetViewHolder {
        val binding = CardSetBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CardSetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardSetViewHolder, position: Int) {
        val cardSet = getItem(position)
        with(holder.binding) {
            with(cardSet) {
                /*cardCount.text = cards?.count().toString()*/
                cardTitle.text = comment
            }
        }
        holder.itemView.setOnLongClickListener { longListener(cardSet) }
        holder.itemView.setOnClickListener { listener(cardSet) }

    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }
}
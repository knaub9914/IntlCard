package com.konstantink.intlcard.presentation.adapters.card

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.konstantink.intlcard.databinding.CardBinding
import com.konstantink.intlcard.databinding.CardSetBinding
import com.konstantink.intlcard.domain.entities.Card
import com.konstantink.intlcard.domain.entities.CardSet
import com.konstantink.intlcard.presentation.adapters.cardset.CardSetCallBack
import com.konstantink.intlcard.presentation.viewholders.CardSetViewHolder
import com.konstantink.intlcard.presentation.viewholders.CardViewHolder

class CardAdapter(private val context: Context,
                  private val longListener: (Card) -> Boolean,
                  private val listener: (Card) -> Unit) :
    ListAdapter<Card, CardViewHolder>(CardCallBack) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = CardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = getItem(position)
        with(holder.binding) {
            with(card) {
                /*cardCount.text = cards?.count().toString()*/
                textContext.text = context
                textOrigin.text = origin
                textTranslation.text = translation
            }
        }
        holder.itemView.setOnLongClickListener { longListener(card) }
        holder.itemView.setOnClickListener { listener(card) }

    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }
}

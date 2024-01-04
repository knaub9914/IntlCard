package com.konstantink.intlcard.presentation.adapters.card

import androidx.recyclerview.widget.DiffUtil
import com.konstantink.intlcard.domain.entities.Card
import com.konstantink.intlcard.domain.entities.CardSet

object CardCallBack: DiffUtil.ItemCallback<Card>(){
    override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean {
        return oldItem == newItem
    }
}
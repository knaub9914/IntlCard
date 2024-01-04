package com.konstantink.intlcard.presentation.adapters.cardset

import androidx.recyclerview.widget.DiffUtil
import com.konstantink.intlcard.domain.entities.CardSet

object CardSetCallBack:DiffUtil.ItemCallback<CardSet>(){
    override fun areItemsTheSame(oldItem: CardSet, newItem: CardSet): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CardSet, newItem: CardSet): Boolean {
        return oldItem == newItem
    }
}
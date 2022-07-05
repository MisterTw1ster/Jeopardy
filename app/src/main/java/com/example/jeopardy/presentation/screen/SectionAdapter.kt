package com.example.jeopardy.presentation.screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jeopardy.databinding.ItemSectionBinding
import com.example.jeopardy.domain.models.Section

interface SectionActionListener {

    fun selectSection(section: Section)
}

class SectionAdapter(
    private val sections: List<Section>,
    private val actionListener: SectionActionListener
): RecyclerView.Adapter<SectionAdapter.SectionsViewHolder>(), View.OnClickListener {

    override fun onClick(v: View) {
        val section = v.tag as Section
        actionListener.selectSection(section)
    }

    class SectionsViewHolder(
        val binding: ItemSectionBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionsViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val binding = ItemSectionBinding.inflate(inflate, parent, false)

        binding.root.setOnClickListener(this)

        return SectionsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SectionsViewHolder, position: Int) {
        val section = sections[position]
        with(holder.binding) {
            holder.itemView.tag = section
            tSection.text = section.name
        }
    }

    override fun getItemCount(): Int = sections.size

}
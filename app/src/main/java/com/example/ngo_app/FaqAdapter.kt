import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ngo_app.FaqItem
import com.example.ngo_app.R

class FaqAdapter(private val faqList: List<FaqItem>) :
    RecyclerView.Adapter<FaqAdapter.FaqViewHolder>() {

    private var expandedPosition = -1

    inner class FaqViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val questionTextView: TextView = itemView.findViewById(R.id.questionTextView)
        val answerTextView: TextView = itemView.findViewById(R.id.answerTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaqViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.faqs_items, parent, false)
        return FaqViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FaqViewHolder, position: Int) {
        val currentItem = faqList[position]
        holder.questionTextView.text = currentItem.question
        holder.answerTextView.text = currentItem.answer

        val isExpanded = position == expandedPosition
        holder.answerTextView.visibility = if (isExpanded) View.VISIBLE else View.GONE

        holder.questionTextView.setOnClickListener {
            expandedPosition = if (isExpanded) -1 else position
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = faqList.size
}

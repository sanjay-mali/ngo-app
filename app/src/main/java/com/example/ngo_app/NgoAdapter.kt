import android.app.Application
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.ngo_app.KnowMore
import com.example.ngo_app.R
import com.example.ngo_app.NgoModel
import com.example.ngo_app.SharedViewModel
import com.example.ngo_app.fragment.OurWork

class NgoAdapter(private val ngoList: List<NgoModel>) :
    RecyclerView.Adapter<NgoAdapter.NgoViewHolder>() {
    class NgoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewNGO: ImageView = itemView.findViewById(R.id.NgoImage)
        val textViewNGOName: TextView = itemView.findViewById(R.id.NgoName)
        val textViewNGOLocation: TextView = itemView.findViewById(R.id.Location)
        val textViewNGODescription: TextView = itemView.findViewById(R.id.NgoDescription)
        val buttonKnowMore: Button = itemView.findViewById(R.id.KnowMoreBtn)
        val buttonDonateNow: Button = itemView.findViewById(R.id.DonateNowBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NgoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.ngos , parent, false)
        return NgoViewHolder(itemView)
    }
    private fun truncateDescription(description: String): String {
        val maxLength = 150 // Maximum characters/words allowed
        return if (description.length <= maxLength) {
            description
        } else {
            val trimmedText = description.substring(0, maxLength)
            val lastSpaceIndex = trimmedText.lastIndexOf(' ')
            if (lastSpaceIndex != -1) {
                trimmedText.substring(0, lastSpaceIndex)
            } else {
                trimmedText
            }
        }
    }
    override fun onBindViewHolder(holder: NgoViewHolder, position: Int) {
        val currentItem = ngoList[position]

        holder.imageViewNGO.setImageResource(currentItem.imageResource)
        holder.textViewNGOName.text = currentItem.name
        holder.textViewNGOLocation.text = currentItem.location

        val truncatedDescription = truncateDescription(currentItem.description)
        holder.textViewNGODescription.text = truncatedDescription
        // Set onClickListeners for buttons if needed
        holder.buttonKnowMore.setOnClickListener {
            // Handle "Know More" button click
            val knowMore = Intent(holder.itemView.context, KnowMore::class.java)
            knowMore.putExtra(KnowMore.EXTRA_NGO_NAME, currentItem.name)
            knowMore.putExtra(KnowMore.EXTRA_NGO_DESCRIPTION, currentItem.description)
            knowMore.putExtra(KnowMore.EXTRA_NGO_LOCATION, currentItem.location)
            knowMore.putExtra(KnowMore.EXTRA_NGO_POSITION, position)
            holder.itemView.context.startActivity(knowMore)

        }


        holder.buttonDonateNow.setOnClickListener {
            // Handle "Donate Now" button click
        }
    }
    private lateinit var sharedViewModel: SharedViewModel

//    private fun handleKnowMoreClick(position: Int) {
//
//        val intent = Intent(ContentProviderCompat.requireContext(), OurWork::class.java)
//        ContextCompat.startActivity(intent)
//    }
    override fun getItemCount() = ngoList.size
}

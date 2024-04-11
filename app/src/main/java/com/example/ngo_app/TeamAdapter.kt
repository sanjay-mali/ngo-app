import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ngo_app.R
import com.example.ngo_app.TeamMember

class TeamAdapter(private val teamList: List<TeamMember>) :
    RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewPhoto: ImageView = itemView.findViewById(R.id.imageViewPhoto)
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val textViewRole: TextView = itemView.findViewById(R.id.textViewRole)
        val textViewBio: TextView = itemView.findViewById(R.id.textViewBio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.ourworkcard, parent, false)
        return TeamViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val currentItem = teamList[position]

        holder.imageViewPhoto.setImageResource(currentItem.photoResId)
        holder.textViewName.text = currentItem.name
        holder.textViewRole.text = currentItem.role
        holder.textViewBio.text = currentItem.bio
    }

    override fun getItemCount() = teamList.size
}

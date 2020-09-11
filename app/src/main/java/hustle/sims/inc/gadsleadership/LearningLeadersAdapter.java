package hustle.sims.inc.gadsleadership;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LearningLeadersAdapter.LearningLeadersViewHolder> {
    Context context;
    List<LeadersHours> mLeadersHoursList;

    public LearningLeadersAdapter(Context context, List<LeadersHours> leadersHoursList) {
        this.context = context;
        mLeadersHoursList = leadersHoursList;
    }

    @Override
    public LearningLeadersViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.learning_leaders_adapter, null);
        LearningLeadersViewHolder learningLeadersViewHolder = new LearningLeadersViewHolder(view);
        return learningLeadersViewHolder;
    }

    @Override
    public void onBindViewHolder(LearningLeadersViewHolder holder, final int position){
        //set data
        holder.learner_name.setText(mLeadersHoursList.get(position).getName());
        holder.learner_skill_iq.setText(mLeadersHoursList.get(position).getHours() + " learning hours, " + mLeadersHoursList.get(position).getCountry());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with user name
                Toast.makeText(context, mLeadersHoursList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount(){
        return mLeadersHoursList.size();
    }


    class LearningLeadersViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView learner_name, learner_skill_iq;

        public LearningLeadersViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            learner_name = (TextView) itemView.findViewById(R.id.learner_name);
            learner_skill_iq = (TextView) itemView.findViewById(R.id.learner_skill_iq);
        }
    }
}

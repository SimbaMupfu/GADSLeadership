package hustle.sims.inc.gadsleadership;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LeadersSkillIQFragment extends Fragment {

    RecyclerView recyclerView;
    List<LeadersSkillIQ> mLeadersSkillIQ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View view = inflater.inflate(R.layout.skill_iq_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewSkill_IQ);
        getLearningLeardersListData(); // call a method in which we have implement our GET type web API
        return view;
    }

    private void getLearningLeardersListData() {
        // display a progress dialog
        final ProgressDialog progressDialog = new ProgressDialog(requireActivity());
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
        progressDialog.show(); // show progress dialog


        (Api.getClient().getLeadersSkillIQ()).enqueue(new Callback<List<LeadersSkillIQ>>() {
            @Override
            public void onResponse(Call<List<LeadersSkillIQ>> call, Response<List<LeadersSkillIQ>> response) {
                Log.d("responseGET", response.body().get(0).getName());
                progressDialog.dismiss(); //dismiss progress dialog
                mLeadersSkillIQ = response.body();
                setDataInRecyclerView();
            }

            @Override
            public void onFailure(Call<List<LeadersSkillIQ>> call, Throwable t) {
                // if error occurs in network transaction then we can get the error in this method.
                Toast.makeText(requireActivity(), t.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss(); //dismiss progress dialog
            }
        });
    }

    private void setDataInRecyclerView() {
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        // call the constructor of UsersAdapter to send the reference and data to Adapter
        SkillIQLeadersAdapter learningLeadersAdapter = new SkillIQLeadersAdapter(requireActivity(), mLeadersSkillIQ);
        recyclerView.setAdapter(learningLeadersAdapter); // set the Adapter to RecyclerView
    }
}

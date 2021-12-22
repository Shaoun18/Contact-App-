package com.seip.android.contactappb1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seip.android.contactappb1.adapters.ContactAdapter;
import com.seip.android.contactappb1.databinding.FragmentContactListBinding;
import com.seip.android.contactappb1.models.MyContact;

public class ContactListFragment extends Fragment {
    private FragmentContactListBinding binding;
    public ContactListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentContactListBinding.inflate(inflater);
        final ContactAdapter adapter = new ContactAdapter(MyContact.getContacts());
        final LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(RecyclerView.VERTICAL);
        binding.contactRV.setLayoutManager(llm);
        binding.contactRV.setAdapter(adapter);
        return binding.getRoot();
    }
}
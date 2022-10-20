package ml.sunyufei.navigation;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        getView().findViewById(R.id.buttonHome).setOnClickListener(view -> {
//            NavController controller = Navigation.findNavController(view);
//            controller.navigate(R.id.action_homeFragment_to_detailFragment);
//        });
        getView().findViewById(R.id.buttonHome)
                .setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_detailFragment));
    }
}
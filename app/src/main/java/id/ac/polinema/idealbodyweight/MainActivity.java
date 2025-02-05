package id.ac.polinema.idealbodyweight;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import id.ac.polinema.idealbodyweight.fragments.AboutFragment;
import id.ac.polinema.idealbodyweight.fragments.BMI;
import id.ac.polinema.idealbodyweight.fragments.BrocaIndexFragment;
import id.ac.polinema.idealbodyweight.fragments.MenuFragment;
import id.ac.polinema.idealbodyweight.fragments.ResultFragment;
import id.ac.polinema.idealbodyweight.util.BodyMassIndex;
import id.ac.polinema.idealbodyweight.util.BrocaIndex;

public class MainActivity extends AppCompatActivity implements MenuFragment.OnFragmentInteractionListener,
		BrocaIndexFragment.OnFragmentInteractionListener,
		ResultFragment.OnFragmentInteractionListener,
		BMI.OnFragmentInteractionListener{

	// Deklarasikan atribut Fragment di sini
	BrocaIndexFragment brocaIndexFragment;
	BMI bmi;
	MenuFragment menuFragment;
	private AboutFragment aboutFragment;
	private ResultFragment resultFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		aboutFragment = AboutFragment.newInstance("Rahadian Bagaskara");
		menuFragment = new MenuFragment();
		brocaIndexFragment = new BrocaIndexFragment();
		bmi = new BMI();
		resultFragment = new ResultFragment();
		getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, menuFragment)
		.commit();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return  true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		// TODO: Tambahkan penanganan menu di sini
		if(item.getItemId() == R.id.menu_about) {
			getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, aboutFragment)
			.addToBackStack(null).commit();
		}
			return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBrocaIndexButtonClicked() {
		getSupportFragmentManager().beginTransaction()
		.replace(R.id.fragment_container, brocaIndexFragment, "BrocaIndexFragment").commit();


	}

	@Override
	public void onBodyMassButtonClicked() {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, bmi, "BodyMassIndex").commit();
	}

	@Override
	public void onCalculateBrocaIndexClicked(float index) {
		resultFragment.setInformation(String.format("Your ideal weight is %.2f kg", index));
		getSupportFragmentManager().beginTransaction()
		.replace(R.id.fragment_container, resultFragment, "bfi")
		.commit();

	}

	@Override
	public void onTryAgainButtonClicked(String tag) {
		if (tag.equals("bfi")) {
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, brocaIndexFragment)
					.commit();
		}

		else if (tag.equals("bmi")) {
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.fragment_container, bmi)
					.commit();
		}
	}

	@Override
	public void onBMIClicked(float index) {
		resultFragment.setInformation(String.format("Your ideal weight is " + index));
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, resultFragment, "bmi")
				.commit();
	}
}

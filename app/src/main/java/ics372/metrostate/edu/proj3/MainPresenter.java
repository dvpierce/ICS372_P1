package ics372.metrostate.edu.proj3;

import android.content.Context;

import com.obsez.android.lib.filechooser.ChooserDialog;
import java.io.File;
//Let the user know if there export and/or import is successful or failed
public class MainPresenter {

    private MainActivity activity;
    private IMainView view;

    public MainPresenter(MainActivity activity, IMainView mainView) {
        this.activity = activity;
        this.view = mainView;
    }
//import
    public void openFileChooser(final Context cont) {
        new ChooserDialog().with(activity)
                .withStartFile("/sdcard")
                .withChosenListener(new ChooserDialog.Result() {
                    @Override
                    public void onChoosePath(String path, File pathFile) {
                        try {
                            boolean isSuccessful = FileReader.read(path, cont);
                            if(isSuccessful) {
                                view.importSuccessful();
                            } else {
                                view.importFailed();
                            }
                        } catch (Exception e) {

                        }
                    }
                })
                .build()
                .show();
    }
//export
    public void exportFile(String fileName) {
        boolean isSuccessful = FileWriter.write(fileName);
        if(isSuccessful) {
            view.exportSuccessful();
        } else {
            view.exportFailed();
        }
    }
}
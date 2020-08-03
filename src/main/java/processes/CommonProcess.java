package processes;

import actions.CommonActions;

public class CommonProcess {

    public CommonProcess() {
    }

    public void navigateTo(String url) {
        new CommonActions().navigateTo(url);
    }
}

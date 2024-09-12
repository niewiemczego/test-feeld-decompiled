package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class CanExecuteFileFilter extends AbstractFileFilter implements Serializable {
    public static final IOFileFilter CANNOT_EXECUTE;
    public static final IOFileFilter CAN_EXECUTE;
    private static final long serialVersionUID = 3179904805251622989L;

    static {
        CanExecuteFileFilter canExecuteFileFilter = new CanExecuteFileFilter();
        CAN_EXECUTE = canExecuteFileFilter;
        CANNOT_EXECUTE = new NotFileFilter(canExecuteFileFilter);
    }

    protected CanExecuteFileFilter() {
    }

    public boolean accept(File file) {
        return file.canExecute();
    }
}

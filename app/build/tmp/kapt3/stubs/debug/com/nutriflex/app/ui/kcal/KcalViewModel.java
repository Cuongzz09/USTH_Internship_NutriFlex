package com.nutriflex.app.ui.kcal;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/nutriflex/app/ui/kcal/KcalViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_history", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/nutriflex/app/network/KcalRecord;", "_measureResult", "history", "Landroidx/lifecycle/LiveData;", "getHistory", "()Landroidx/lifecycle/LiveData;", "measureResult", "getMeasureResult", "", "userId", "", "measureAndSave", "request", "Lcom/nutriflex/app/network/KcalRequest;", "app_debug"})
public final class KcalViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.nutriflex.app.network.KcalRecord>> _history = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.nutriflex.app.network.KcalRecord>> history = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.nutriflex.app.network.KcalRecord> _measureResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.nutriflex.app.network.KcalRecord> measureResult = null;
    
    public KcalViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.nutriflex.app.network.KcalRecord>> getHistory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.nutriflex.app.network.KcalRecord> getMeasureResult() {
        return null;
    }
    
    public final void getHistory(long userId) {
    }
    
    public final void measureAndSave(@org.jetbrains.annotations.NotNull()
    com.nutriflex.app.network.KcalRequest request) {
    }
}
package com.nutriflex.app.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/nutriflex/app/network/KcalApi;", "", "getHistory", "", "Lcom/nutriflex/app/network/KcalRecord;", "userId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "measureAndSave", "req", "Lcom/nutriflex/app/network/KcalRequest;", "(Lcom/nutriflex/app/network/KcalRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface KcalApi {
    
    @retrofit2.http.POST(value = "api/kcal/measure")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object measureAndSave(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.nutriflex.app.network.KcalRequest req, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nutriflex.app.network.KcalRecord> $completion);
    
    @retrofit2.http.GET(value = "api/kcal/history/{userId}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getHistory(@retrofit2.http.Path(value = "userId")
    long userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.nutriflex.app.network.KcalRecord>> $completion);
}
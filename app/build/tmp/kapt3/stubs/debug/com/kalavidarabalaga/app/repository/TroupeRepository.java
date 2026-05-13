package com.kalavidarabalaga.app.repository;

/**
 * Repository for all Firestore operations related to Troupes.
 * All suspend functions are safe to call from a ViewModel coroutine scope.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ8\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0014J\u000e\u0010\u0015\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/kalavidarabalaga/app/repository/TroupeRepository;", "", "()V", "collection", "Lcom/google/firebase/firestore/CollectionReference;", "db", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getAllTroupes", "", "Lcom/kalavidarabalaga/app/model/Troupe;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFeaturedTroupes", "getTroupeById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchTroupes", "district", "artType", "query", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "seedSampleData", "", "app_debug"})
public final class TroupeRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore db = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.CollectionReference collection = null;
    
    public TroupeRepository() {
        super();
    }
    
    /**
     * Fetch all featured troupes (for Home screen)
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getFeaturedTroupes(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.kalavidarabalaga.app.model.Troupe>> $completion) {
        return null;
    }
    
    /**
     * Fetch all troupes
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllTroupes(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.kalavidarabalaga.app.model.Troupe>> $completion) {
        return null;
    }
    
    /**
     * Fetch troupes filtered by district and/or art type
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object searchTroupes(@org.jetbrains.annotations.Nullable()
    java.lang.String district, @org.jetbrains.annotations.Nullable()
    java.lang.String artType, @org.jetbrains.annotations.Nullable()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.kalavidarabalaga.app.model.Troupe>> $completion) {
        return null;
    }
    
    /**
     * Fetch a single troupe by ID
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getTroupeById(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.kalavidarabalaga.app.model.Troupe> $completion) {
        return null;
    }
    
    /**
     * Seed sample troupes to Firestore for demo/testing
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object seedSampleData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}
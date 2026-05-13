package com.kalavidarabalaga.app.viewmodel;

/**
 * ViewModel shared between HomeFragment and SearchFragment.
 * Exposes LiveData for UI state.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u001bJ*\u0010\u001d\u001a\u00020\u001b2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005J\u0006\u0010!\u001a\u00020\u001bJ\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\bR\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010\u00a8\u0006$"}, d2 = {"Lcom/kalavidarabalaga/app/viewmodel/TroupeViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_error", "Landroidx/lifecycle/MutableLiveData;", "", "_featuredTroupes", "", "Lcom/kalavidarabalaga/app/model/Troupe;", "_isLoading", "", "_searchResults", "_selectedTroupe", "error", "Landroidx/lifecycle/LiveData;", "getError", "()Landroidx/lifecycle/LiveData;", "featuredTroupes", "getFeaturedTroupes", "isLoading", "repository", "Lcom/kalavidarabalaga/app/repository/TroupeRepository;", "searchResults", "getSearchResults", "selectedTroupe", "getSelectedTroupe", "loadAllTroupes", "", "loadFeaturedTroupes", "searchTroupes", "query", "district", "artType", "seedData", "selectTroupe", "troupe", "app_debug"})
public final class TroupeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.kalavidarabalaga.app.repository.TroupeRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.kalavidarabalaga.app.model.Troupe>> _featuredTroupes = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.kalavidarabalaga.app.model.Troupe>> featuredTroupes = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.kalavidarabalaga.app.model.Troupe>> _searchResults = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.kalavidarabalaga.app.model.Troupe>> searchResults = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _error = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> error = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.kalavidarabalaga.app.model.Troupe> _selectedTroupe = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.kalavidarabalaga.app.model.Troupe> selectedTroupe = null;
    
    public TroupeViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.kalavidarabalaga.app.model.Troupe>> getFeaturedTroupes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.kalavidarabalaga.app.model.Troupe>> getSearchResults() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getError() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.kalavidarabalaga.app.model.Troupe> getSelectedTroupe() {
        return null;
    }
    
    /**
     * Load featured troupes for the Home screen
     */
    public final void loadFeaturedTroupes() {
    }
    
    /**
     * Search troupes with optional filters
     */
    public final void searchTroupes(@org.jetbrains.annotations.Nullable()
    java.lang.String query, @org.jetbrains.annotations.Nullable()
    java.lang.String district, @org.jetbrains.annotations.Nullable()
    java.lang.String artType) {
    }
    
    /**
     * Load all troupes (initial search screen load)
     */
    public final void loadAllTroupes() {
    }
    
    /**
     * Set the troupe selected for profile view
     */
    public final void selectTroupe(@org.jetbrains.annotations.NotNull()
    com.kalavidarabalaga.app.model.Troupe troupe) {
    }
    
    /**
     * Seed sample data (call once for demo)
     */
    public final void seedData() {
    }
}
package com.kalavidarabalaga.app.adapter;

/**
 * Fixed 2-column grid adapter for the Search screen.
 * Always shows exactly 4 tiles — real art forms fill first slots,
 * remaining slots show a "Coming Soon" placeholder.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0015\u0016BQ\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\b2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/kalavidarabalaga/app/adapter/ArtFormGridAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/kalavidarabalaga/app/adapter/ArtFormGridAdapter$VH;", "items", "", "Lcom/kalavidarabalaga/app/data/ArtFormData$ArtForm;", "onViewProfile", "Lkotlin/Function1;", "", "onBook", "onCall", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "VH", "app_debug"})
public final class ArtFormGridAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.kalavidarabalaga.app.adapter.ArtFormGridAdapter.VH> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.kalavidarabalaga.app.data.ArtFormData.ArtForm> items = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.kalavidarabalaga.app.data.ArtFormData.ArtForm, kotlin.Unit> onViewProfile = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.kalavidarabalaga.app.data.ArtFormData.ArtForm, kotlin.Unit> onBook = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.kalavidarabalaga.app.data.ArtFormData.ArtForm, kotlin.Unit> onCall = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.kalavidarabalaga.app.adapter.ArtFormGridAdapter.Companion Companion = null;
    
    public ArtFormGridAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.kalavidarabalaga.app.data.ArtFormData.ArtForm> items, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.kalavidarabalaga.app.data.ArtFormData.ArtForm, kotlin.Unit> onViewProfile, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.kalavidarabalaga.app.data.ArtFormData.ArtForm, kotlin.Unit> onBook, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.kalavidarabalaga.app.data.ArtFormData.ArtForm, kotlin.Unit> onCall) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.kalavidarabalaga.app.adapter.ArtFormGridAdapter.VH onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.kalavidarabalaga.app.adapter.ArtFormGridAdapter.VH holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2 = {"Lcom/kalavidarabalaga/app/adapter/ArtFormGridAdapter$Companion;", "", "()V", "padToGrid", "", "Lcom/kalavidarabalaga/app/data/ArtFormData$ArtForm;", "artForms", "minSlots", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Always pads list to a minimum of 4 slots (null = placeholder).
         */
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.kalavidarabalaga.app.data.ArtFormData.ArtForm> padToGrid(@org.jetbrains.annotations.NotNull()
        java.util.List<com.kalavidarabalaga.app.data.ArtFormData.ArtForm> artForms, int minSlots) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/kalavidarabalaga/app/adapter/ArtFormGridAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "b", "Lcom/kalavidarabalaga/app/databinding/ItemArtFormGridBinding;", "(Lcom/kalavidarabalaga/app/adapter/ArtFormGridAdapter;Lcom/kalavidarabalaga/app/databinding/ItemArtFormGridBinding;)V", "bind", "", "af", "Lcom/kalavidarabalaga/app/data/ArtFormData$ArtForm;", "app_debug"})
    public final class VH extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.kalavidarabalaga.app.databinding.ItemArtFormGridBinding b = null;
        
        public VH(@org.jetbrains.annotations.NotNull()
        com.kalavidarabalaga.app.databinding.ItemArtFormGridBinding b) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.Nullable()
        com.kalavidarabalaga.app.data.ArtFormData.ArtForm af) {
        }
    }
}
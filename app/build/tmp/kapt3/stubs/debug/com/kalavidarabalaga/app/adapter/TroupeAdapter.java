package com.kalavidarabalaga.app.adapter;

/**
 * RecyclerView adapter for displaying Troupe cards on the Home and Search screens.
 * Uses ListAdapter with DiffUtil for efficient updates.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0010\u0011B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u00020\u00062\n\u0010\t\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/kalavidarabalaga/app/adapter/TroupeAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/kalavidarabalaga/app/model/Troupe;", "Lcom/kalavidarabalaga/app/adapter/TroupeAdapter$TroupeViewHolder;", "onTroupeClick", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "TroupeViewHolder", "app_debug"})
public final class TroupeAdapter extends androidx.recyclerview.widget.ListAdapter<com.kalavidarabalaga.app.model.Troupe, com.kalavidarabalaga.app.adapter.TroupeAdapter.TroupeViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.kalavidarabalaga.app.model.Troupe, kotlin.Unit> onTroupeClick = null;
    @org.jetbrains.annotations.NotNull()
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<com.kalavidarabalaga.app.model.Troupe> DIFF_CALLBACK = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.kalavidarabalaga.app.adapter.TroupeAdapter.Companion Companion = null;
    
    public TroupeAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.kalavidarabalaga.app.model.Troupe, kotlin.Unit> onTroupeClick) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.kalavidarabalaga.app.adapter.TroupeAdapter.TroupeViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.kalavidarabalaga.app.adapter.TroupeAdapter.TroupeViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/kalavidarabalaga/app/adapter/TroupeAdapter$Companion;", "", "()V", "DIFF_CALLBACK", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/kalavidarabalaga/app/model/Troupe;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/kalavidarabalaga/app/adapter/TroupeAdapter$TroupeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/kalavidarabalaga/app/databinding/ItemTroupeCardBinding;", "(Lcom/kalavidarabalaga/app/adapter/TroupeAdapter;Lcom/kalavidarabalaga/app/databinding/ItemTroupeCardBinding;)V", "bind", "", "troupe", "Lcom/kalavidarabalaga/app/model/Troupe;", "app_debug"})
    public final class TroupeViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.kalavidarabalaga.app.databinding.ItemTroupeCardBinding binding = null;
        
        public TroupeViewHolder(@org.jetbrains.annotations.NotNull()
        com.kalavidarabalaga.app.databinding.ItemTroupeCardBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.kalavidarabalaga.app.model.Troupe troupe) {
        }
    }
}
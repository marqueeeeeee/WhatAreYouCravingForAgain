	package com.aduhack.whatareyoucravingforagain.common;

    import android.content.Context;
    import android.content.res.Resources;
    import android.graphics.Bitmap;
    import android.os.AsyncTask;
    import android.view.View;
    import android.view.ViewGroup;
    import android.view.animation.AccelerateDecelerateInterpolator;
    import android.view.animation.AlphaAnimation;
    import android.view.animation.Animation;
    import android.view.animation.AnimationSet;
    import android.view.animation.ScaleAnimation;
    import android.view.animation.TranslateAnimation;
    import android.widget.BaseAdapter;
    import android.widget.ImageButton;
    import android.widget.TextView;

    import com.aduhack.whatareyoucravingforagain.R;
    import com.aduhack.whatareyoucravingforagain.model.ListViewAdapterModelWithAvatar;
    import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
    import com.nostra13.universalimageloader.core.DisplayImageOptions;
    import com.nostra13.universalimageloader.core.ImageLoader;
    import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
    import com.nostra13.universalimageloader.core.assist.ImageScaleType;

    import java.util.ArrayList;

    public class CustomListViewAdapter extends BaseAdapter{

	private ViewHolder _holder;
	private Context _context;
	private ArrayList<ListViewAdapterModelWithAvatar> _items;
	private TranslateAnimation animation = null;
	private ScaleAnimation scale = null;
	private AlphaAnimation alp;
	private AnimationSet set;
	private int mPrevPos = -1;
	
	
	public CustomListViewAdapter(Context context, ArrayList<ListViewAdapterModelWithAvatar> items) {
		_context = context;
		_items = items;
		
		DisplayImageOptions option = new DisplayImageOptions.Builder()
		.delayBeforeLoading(1000).resetViewBeforeLoading(false)
		.cacheInMemory(true).cacheOnDisk(false)
		.imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
		.bitmapConfig(Bitmap.Config.ARGB_8888).build();
		
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				context).memoryCacheExtraOptions(480, 800).threadPoolSize(10)
				.memoryCache(new LruMemoryCache(2 * 1024 * 1024))
				.memoryCacheSize(2 * 1024 * 1024)
				.defaultDisplayImageOptions(option).build();

		ImageLoader.getInstance().init(config);
		
	}
	
	@Override
	public int getCount() {
		return _items.size();
	}

	@Override
	public Object getItem(int position) {
		return _items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return _items.get(position).Id;
	}
	
	public void remove(int position) {
		_items.remove(position);
	}

	public void setAnimation(View view) {
		AccelerateDecelerateInterpolator interpolator = new AccelerateDecelerateInterpolator();
		
		animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
				Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
				1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
		
		scale = new ScaleAnimation(0.5f, 1.0f, 0.5f, 1.0f,
				view.getTranslationX() - (view.getWidth() / 2),
				view.getTranslationY() - (view.getHeight() / 2));
		
		alp = new AlphaAnimation(0.0f, 1.0f);
		alp.setDuration(200);
		
		set = new AnimationSet(true);
		set.setInterpolator(interpolator);
		set.addAnimation(animation);
		set.addAnimation(scale);
		set.addAnimation(alp);
		set.setDuration(200);

	}

	
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		
		if(view == null) {

            view = View.inflate(_context, R.layout.adapter_custom_listview, null);
			_holder = new ViewHolder();
			_holder.initialize(view);
			view.setTag(_holder);
		}
		else {
			_holder = (ViewHolder) view.getTag();
		}
		
		_holder.MainTextView.setText(_items.get(position).MainText);
		_holder.SubTextView.setText(_items.get(position).SubText);
        _holder.PriceTextView.setText(_items.get(position).PriceText);
		

		new SetImage(position, _holder, _items.get(position), _context)
				.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
	
		if (mPrevPos != position) {
			setAnimation(view);
			view.startAnimation(set);
			_holder.Thumbnail.setAnimation(alp);
			mPrevPos = position;
		}
		
		return view;
	}
	
	private class SetImage extends AsyncTask<Void, Void, Void>
	{
		private ViewHolder _holder;
		private Context _context;
		private ListViewAdapterModelWithAvatar _items;
		private int pos;
		
		DisplayImageOptions option = new DisplayImageOptions.Builder().delayBeforeLoading(200) //.showImageOnLoading(R.drawable.halloweeen)
		.resetViewBeforeLoading(false).cacheInMemory(true)
		.cacheOnDisk(false)
		.imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
		.bitmapConfig(Bitmap.Config.ARGB_8888).build();

		public SetImage(int position,ViewHolder holder, ListViewAdapterModelWithAvatar items, Context context) {
			_context = context;
			_holder = holder;
			_items = items;
			pos = position;
		}
		
		@Override
		protected Void doInBackground(Void... params) { 
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			
			//if(_items.ImageSrc == null) {
				final Resources res = _context.getResources();
				final int tileSize = res
						.getDimensionPixelSize(R.dimen.letter_tile_size);

				final TileProvider tileProvider = new TileProvider(_context);
				final Bitmap letterTile = tileProvider.getLetterTile(
						_items.MainText, _items.Id + "", tileSize, tileSize);

				_holder.Thumbnail.setImageBitmap(letterTile);
			//}
			//else {
				//_holder.Thumbnail.setImageResource(R.drawable.me);
			//}
			//
		}
		
	}
	
	private static class ViewHolder {
		public CircleImageView Thumbnail;
		public TextView MainTextView;
		public TextView SubTextView;
        public TextView PriceTextView;
		public ImageButton ActionButton;
		
		public void initialize(View view)
		{
			Thumbnail = (CircleImageView) view.findViewById(R.id.lv_custom_imgView);
			MainTextView = (TextView) view.findViewById(R.id.lv_custom_mainTextView);
			SubTextView = (TextView) view.findViewById(R.id.lv_custom_subTextView);
            PriceTextView = (TextView) view.findViewById(R.id.lv_custom_priceTextView);
		}
	}
}

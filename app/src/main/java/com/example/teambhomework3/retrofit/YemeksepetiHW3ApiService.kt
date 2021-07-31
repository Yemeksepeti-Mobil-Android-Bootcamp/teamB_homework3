package com.example.teambhomework3.retrofit

import com.example.teambhomework3.models.core.Food
import com.example.teambhomework3.models.core.Order
import com.example.teambhomework3.models.core.Restaurant
import com.example.teambhomework3.models.core.User
import com.example.teambhomework3.models.listing.YemeksepetiHW3BaseListingResponse
import retrofit2.Call
import retrofit2.http.*

interface YemeksepetiHW3ApiService {
    @GET("foods")
    fun listFoods(@Query("page") page: Int): Call<YemeksepetiHW3BaseListingResponse<Food>>

    @GET("restaurants")
    fun listRestaurants(@Query("page") page: Int): Call<YemeksepetiHW3BaseListingResponse<Restaurant>>

    @GET("orders")
    fun listOrders(@Query("page") page: Int): Call<YemeksepetiHW3BaseListingResponse<Order>>

    @GET("users")
    fun listUsers(@Query("page") page: Int): Call<YemeksepetiHW3BaseListingResponse<User>>

    @GET("foods/{food_id}")
    fun getFood(@Path("food_id") food_id: Int): Call<Food>

    @GET("restaurants/{restaurant_id}")
    fun getRestaurant(@Path("restaurant_id") restaurant_id: Int): Call<Restaurant>

    @GET("orders/{order_id}")
    fun getOrder(@Path("order_id") order_id: Int): Call<Order>

    @GET("users/{user_id}")
    fun getUser(@Path("user_id") user_id: Int): Call<User>

    @POST("foods/store")
    fun storeFood(
        @Field("name") name: String,
        @Field("price") price: Double,
        @Field("imageUrl") imageUrl: String,
    ): Call<StoreResponse<Food>>

    @POST("restaurants/store")
    fun storeRestaurant(
        @Field("name") name: String,
        @Field("typeOfRestaurant") typeOfRestaurant: String,
        @Field("logoUrl") logoUrl: String,
    ): Call<StoreResponse<Restaurant>>

    @POST("orders/store")
    fun storeOrder(
        @Field("userId") userId: Int,
        @Field("restaurantId") restaurantId: Int,
        @Field("orderNote") orderNote: String,
        @Field("orderPaymentMethod") orderPaymentMethod: Order.PaymentMethods,
    ): Call<StoreResponse<Order>>

    @POST("users/store")
    fun storeUser(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("firstName") firstName: String,
        @Field("lastName") lastName: String,
        @Field("mobileNumber") mobileNumber: String,
        @Field("avatarUrl") avatarUrl: String,
    ): Call<StoreResponse<User>>

    @POST("foods/update/{food_id}")
    fun updateFood(
        @Path("food_id") food_id: Int,
        @Field("name") name: String?,
        @Field("price") price: Double?,
        @Field("imageUrl") imageUrl: String?,
    ): Call<StoreResponse<Food>>

    @POST("restaurants/update/{restaurant_id}")
    fun updateRestaurant(
        @Path("restaurant_id") restaurant_id: Int,
        @Field("name") name: String?,
        @Field("typeOfRestaurant") typeOfRestaurant: String?,
        @Field("logoUrl") logoUrl: String?,
    ): Call<StoreResponse<Restaurant>>

    @POST("orders/update/{order_id}")
    fun updateOrder(
        @Path("order_id") order_id: Int,
        @Field("userId") userId: Int?,
        @Field("restaurantId") restaurantId: Int?,
        @Field("orderNote") orderNote: String?,
        @Field("orderPaymentMethod") orderPaymentMethod: Order.PaymentMethods?,
    ): Call<StoreResponse<Order>>

    @POST("users/update/{user_id}")
    fun updateUser(
        @Path("user_id") user_id: Int,
        @Field("email") email: String?,
        @Field("password") password: String?,
        @Field("firstName") firstName: String?,
        @Field("lastName") lastName: String?,
        @Field("mobileNumber") mobileNumber: String?,
        @Field("avatarUrl") avatarUrl: String?,
    ): Call<StoreResponse<User>>

    @POST("restaurants/address/{restaurant_id}")
    fun storeRestaurantAddress(
        @Path("restaurant_id") restaurant_id: Int,
        @Field("country") country: String,
        @Field("city") city: String,
        @Field("neighborhood") neighborhood: String,
        @Field("street") street: String,
        @Field("latitude") latitude: Double?,
        @Field("longitude") longitude: Double?,
    ): Call<StoreResponse<Restaurant>>

    @POST("users/address/{user_id}")
    fun storeUserAddress(
        @Path("user_id") user_id: Int,
        @Field("country") country: String,
        @Field("city") city: String,
        @Field("neighborhood") neighborhood: String,
        @Field("street") street: String,
        @Field("latitude") latitude: Double?,
        @Field("longitude") longitude: Double?,
    ): Call<StoreResponse<User>>

    @POST("restaurants/food")
    fun storeRestaurantFood(
        @Field("restaurantId") restaurantId: Int,
        @Field("foodId") foodId: Int,
    ): Call<StoreResponse<Restaurant>>

    @DELETE("foods/delete/{food_id}")
    fun deleteFood(
        @Path("food_id") food_id: Int
    ): Call<DeleteResponse>

    @DELETE("restaurants/delete/{restaurant_id}")
    fun deleteRestaurant(
        @Path("restaurant_id") restaurant_id: Int
    ): Call<DeleteResponse>

    @DELETE("orders/delete/{order_id}")
    fun deleteOrder(
        @Path("order_id") order_id: Int
    ): Call<DeleteResponse>

    @DELETE("users/delete/{user_id}")
    fun deleteUser(
        @Path("user_id") user_id: Int
    ): Call<DeleteResponse>
}
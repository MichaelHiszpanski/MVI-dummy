package com.example.mvi_dummy.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>

    @Insert
    suspend fun insertAll(vararg users: User)

    @Query("DELETE FROM user")
    suspend fun deleteAll(): Int

}
//@Dao
//interface EmployeeDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(entity:EmplyeeEntity)
//    @Update
//    suspend fun update(entity:EmplyeeEntity)
//    @Delete
//    suspend fun delete(entity:EmplyeeEntity)
//    @Query("SELECT * FROM `employee-table`")
//    fun fetcheAllEmployees(): Flow<List<EmplyeeEntity>>
//    @Query("SELECT * FROM `employee-table` where id=:id")
//    @JvmSuppressWildcards
//    fun fetcheAllEmployeesById(id:Int): Flow<EmplyeeEntity>
//}
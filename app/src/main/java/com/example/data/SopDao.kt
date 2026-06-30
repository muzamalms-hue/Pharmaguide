package com.example.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SopDao {
    @Query("SELECT * FROM sops ORDER BY id ASC")
    fun getAllSops(): Flow<List<SopEntity>>

    @Query("SELECT * FROM sops WHERE id = :id LIMIT 1")
    fun getSopById(id: Int): Flow<SopEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSops(sops: List<SopEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSop(sop: SopEntity)

    @Query("UPDATE sops SET isBookmarked = :isBookmarked WHERE id = :id")
    suspend fun updateBookmark(id: Int, isBookmarked: Boolean)

    @Query("UPDATE sops SET isSignedOff = 1, signOffBy = :userRole, signOffTimestamp = :timestamp WHERE id = :id")
    suspend fun signOffSop(id: Int, userRole: String, timestamp: Long)

    @Query("""
        SELECT * FROM sops 
        WHERE (title LIKE '%' || :query || '%' OR code LIKE '%' || :query || '%' OR section LIKE '%' || :query || '%' OR procedure LIKE '%' || :query || '%')
    """)
    fun searchSops(query: String): Flow<List<SopEntity>>

    @Query("""
        SELECT * FROM sops 
        WHERE department IN (:departments) AND 
              (title LIKE '%' || :query || '%' OR code LIKE '%' || :query || '%' OR section LIKE '%' || :query || '%' OR procedure LIKE '%' || :query || '%')
    """)
    fun searchSopsInDepartments(query: String, departments: List<String>): Flow<List<SopEntity>>

    @Query("SELECT COUNT(*) FROM sops")
    suspend fun getCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContactInquiry(inquiry: ContactInquiryEntity)

    @Query("SELECT * FROM contact_inquiries ORDER BY timestamp DESC")
    fun getAllContactInquiries(): Flow<List<ContactInquiryEntity>>

    @Query("SELECT * FROM user_monographs ORDER BY timestamp DESC")
    fun getAllUserMonographs(): Flow<List<UserMonographEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserMonograph(monograph: UserMonographEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserMonographs(monographs: List<UserMonographEntity>)

    @Query("DELETE FROM user_monographs WHERE id = :id")
    suspend fun deleteUserMonograph(id: Int)
}

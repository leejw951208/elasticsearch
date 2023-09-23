package demo.elasticsearch.product.entity

import demo.elasticsearch.common.BaseTimeEntity
import jakarta.persistence.*
import org.hibernate.annotations.Comment
import org.hibernate.annotations.DynamicUpdate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@DynamicUpdate
@EntityListeners(AuditingEntityListener::class)
@Entity
@Table(name = "t_product_metrics")
class ProductMetrics(
    product: Product
) : BaseTimeEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L
        protected set

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    var product = product
        protected set

    @Comment("상품 조회수")
    @Column(name = "views")
    var views: Int = 0
        protected set

    @Comment("상품 좋아요")
    @Column(name = "likes")
    var likes: Int = 0
        protected set

    fun addViews(views: Int) {
        this.views.plus(views)
    }

    fun addLikes(likes: Int) {
        this.likes.plus(likes)
    }
}
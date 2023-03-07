import shared
import SwiftUI
import SDWebImageSwiftUI

struct ProductItemView: View {
    let product: ProductModel

    var body: some View {
        VStack(alignment: .leading) {
            HStack {
                Text(product.title)
                    .font(.title2)

                Spacer()

                Text("$ \(product.price)")
                    .font(.title2)
            }

            Text(product.description_)
                .padding(.top)
                .foregroundColor(.gray)
                .multilineTextAlignment(.leading)
                .lineLimit(3)


            AnimatedImage(url: URL(string: product.images.first!))
                .resizable()
                .scaledToFill()
                .frame(height: 200)
                .cornerRadius(10)
        }
    }
}

struct ProductItemView_Previews: PreviewProvider {
    static var previews: some View {
        ProductItemView(product: ProductModel(
            id: 68,
            title: "Refined Metal Gloves",
            price: 300,
            description: "The Nagasaki Lander is the trademarked name of several series of Nagasaki sport bikes, that started with the 1984 ABC800J",
            images: [
                "https://api.lorem.space/image/fashion?w=640&h=480&r=4415",
                "https://api.lorem.space/image/fashion?w=640&h=480&r=6818",
                "https://api.lorem.space/image/fashion?w=640&h=480&r=3530",
            ],
            category: CategoryModel(
                id: 1,
                name: "Clothes",
                image: "https://api.lorem.space/image/fashion?w=640&h=480&r=4288"
            )
        )
        )
        .previewLayout(.sizeThatFits)
        .padding()
    }
}
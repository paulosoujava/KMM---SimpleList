import SwiftUI
import shared

struct ContentView: View {
    @State private var products: [ProductModel] = []

	var body: some View {
        NavigationView {
            List(products, id: \.id) { product in
                ProductItemView(product: product)
            }
            .navigationTitle("Products")
        }.onAppear {
            GetProductsUseCase().execute(request: KotlinUnit()) { products, error in
                guard let products = products else { return }
                DispatchQueue.main.async {
                    self.products = products
                }

            }
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}